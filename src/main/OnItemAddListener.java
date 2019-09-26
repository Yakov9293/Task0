package main;

public interface OnItemAddListener<T> {
    void onPreAdd(T item);
    void onPostAdd(T item);
}
