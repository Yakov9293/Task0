package main;

public class Main {
    public static void main(String[] args) throws Exception {
        OnItemAddArrayList<Item> list1 = new OnItemAddArrayList<>();
        list1.setOnItemAddListener(new DefaultOnItemAddListener<Item>());

        for (int i = 0; i < 10; i++) {
            list1.add(new Item(i));
        }

        System.out.println("List 1: ");
        list1.forEach(item -> System.out.print(item.id + " "));
    }
}



