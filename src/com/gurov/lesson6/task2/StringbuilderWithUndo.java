package com.gurov.lesson6.task2;

public class StringbuilderWithUndo {

    public static void main(String[] args) {

        StringbuilderWithUndo app = new StringbuilderWithUndo();
        app.Start();
    }

    public static void Start(){

        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder("Hello World!");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.reverse();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.append(" World!");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.appendCodePoint(3);
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.delete(2,4);
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.deleteCharAt(5);
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.replace(3,7,"p ");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.insert(3,"hello");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
        System.out.println(undoableStringBuilder.toString());
    }
}
