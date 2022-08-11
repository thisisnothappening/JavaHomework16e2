package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop <T extends ShopItem> {

    private final List<T> itemList = new ArrayList<>();
    private final List<String> nameList = new ArrayList<>();

    public void addItem(T item) {
        if (nameList.contains(item.name())) {
            throw new RuntimeException("This item already exists");
        }
        itemList.add(item);
        nameList.add(item.name());
    }

    public List<T> getItemList() {
        return itemList;
    }

    public List<T> findByCategory(Category category) {
        List<T> itemsOfACategory = new ArrayList<>();
        for (T item : itemList) {
            if (category.equals(item.category())) {
                itemsOfACategory.add(item);
            }
        }
        return itemsOfACategory;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> lowerPriceList = new ArrayList<>();
        for (T item : itemList) {
            if (item.price() <= maxPrice) {
                lowerPriceList.add(item);
            }
        }
        return lowerPriceList;
    }

    public Optional<T> findByName(String name) {
        for (T item : itemList) {
            if (name.equals(item.name())) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<T> removeItem(String name) {
        for (T item : itemList) {
            if (name.equals(item.name())) {
                itemList.remove(item);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public List<String> getAllItemNames() {
        List<String> nameList = new ArrayList<>();
        for (T item : itemList) {
            nameList.add(item.name());
        }
        return nameList;
    }
}
