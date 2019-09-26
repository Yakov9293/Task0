package main;

import java.util.ArrayList;

public class OnItemAddArrayList<E> extends ArrayList<E> {
    private OnItemAddListener<E> listener;

    @Override
    public boolean add(E item) {
        listener.onPreAdd(item);
        boolean result = super.add(item);
        listener.onPostAdd(item);
        return result;
    }

    public void setOnItemAddListener(OnItemAddListener<E> listener) {
        this.listener = listener;
    }
}
