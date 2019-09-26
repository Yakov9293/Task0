package main;

public class DefaultOnItemAddListener<T> implements OnItemAddListener<T> {

    @Override
    public void onPreAdd(T item) {
        System.out.println("Это случилось перед добавлением элемента " + item);
    }

    @Override
    public void onPostAdd(T item) {
        System.out.println("Это случилось после добавления элемента " + item);
    }
}
