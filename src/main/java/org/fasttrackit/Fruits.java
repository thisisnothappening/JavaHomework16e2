package org.fasttrackit;

import java.util.Objects;

public class Fruits implements ShopItem {
    private final String name;
    private final int price;
    private final Category category;

    public Fruits(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruits fruits)) return false;

        if (price != fruits.price) return false;
        if (!Objects.equals(name, fruits.name)) return false;
        return category == fruits.category;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
