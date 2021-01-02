package comparators;

import task2.Item;

import java.util.Comparator;

public class CountComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o2.getCount(), o1.getCount());
    }
}
