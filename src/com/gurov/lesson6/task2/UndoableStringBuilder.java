package com.gurov.lesson6.task2;

import java.util.Stack;

public class UndoableStringBuilder {

    private interface Action{

        void undo();
    }

    private class DeleteAction implements Action{

        private int size;

        public DeleteAction(int size) {

            this.size = size;
        }

        public void undo(){

            stringBuilder.delete(stringBuilder.length() - size,
                    stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;

    private Stack<Action> actions = new Stack<>();

    public UndoableStringBuilder(){

        stringBuilder = new StringBuilder();
    }

    public UndoableStringBuilder(int capacity){

        stringBuilder = new StringBuilder(capacity);
    }

    public UndoableStringBuilder(String string) {

        stringBuilder = new StringBuilder(string);
    }

    public UndoableStringBuilder(CharSequence chars){

        stringBuilder = new StringBuilder(chars);
    }

    public UndoableStringBuilder reverse() {

        stringBuilder.reverse();
        Action action = new Action(){
            public void undo() {
                stringBuilder.reverse();
            }
        };
        actions.add(action);
        return this;
    }


    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - str.length(),
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }

    public UndoableStringBuilder appendCodePoint(int codePoint) {
        int lengthBefore = stringBuilder.length();
        stringBuilder.appendCodePoint(codePoint);
        actions.add(new DeleteAction(stringBuilder.length() - lengthBefore));
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        actions.add(() -> stringBuilder.insert(start, deleted));
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(() -> stringBuilder.insert(index, deleted));
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        actions.add(() -> stringBuilder.replace(start, end - str.length(), deleted));
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        actions.add(() -> stringBuilder.delete(offset, offset + str.length()));
        return this;
    }

    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }
}
