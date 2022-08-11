package org.fasttrackit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Shop<Clothes> clothesShop;
    private Shop<Fruits> fruitsShop;
    private Shop<Electronics> electronicsShop;

    @BeforeEach
    void setUp() {
        clothesShop = new Shop<>();
        fruitsShop = new Shop<>();
        electronicsShop = new Shop<>();

        clothesShop.addItem(new Clothes("jeans", 60, Category.ON_SALE));
        clothesShop.addItem(new Clothes("shirt", 50, Category.NEW));
        clothesShop.addItem(new Clothes("hat", 20, Category.NEW));
        clothesShop.addItem(new Clothes("jacket", 130, Category.REFURBISHED));
        clothesShop.addItem(new Clothes("shoes", 115, Category.REFURBISHED));
    }

    @AfterEach
    void tearDown() {
        clothesShop = null;
        fruitsShop = null;
        electronicsShop = null;
    }

    @Test
    void testAddItem() {
        Assertions.assertThat(clothesShop.getItemList()).contains(
                new Clothes("jeans", 60, Category.ON_SALE),
                new Clothes("shirt", 50, Category.NEW),
                new Clothes("jacket", 130, Category.REFURBISHED)
        );
    }

    @Test
    void testAddItemException() {
        boolean thrown = false;
        try {
            clothesShop.addItem(new Clothes("jeans", 70, Category.REFURBISHED));
        } catch (RuntimeException e) {
            thrown = true;
        }
        org.junit.jupiter.api.Assertions.assertTrue(thrown);
    }

    @Test
    void testFindByCategory() {
        Assertions.assertThat(clothesShop.findByCategory(Category.REFURBISHED)).containsExactly(
                new Clothes("jacket", 130, Category.REFURBISHED),
                new Clothes("shoes", 115, Category.REFURBISHED)
        );
    }

    @Test
    void testFindWithLowerPrice() {
        Assertions.assertThat(clothesShop.findWithLowerPrice(100)).containsExactly(
                new Clothes("jeans", 60, Category.ON_SALE),
                new Clothes("shirt", 50, Category.NEW),
                new Clothes("hat", 20, Category.NEW)
        );
    }

    @Test
    void testFindByName() {
        Assertions.assertThat(clothesShop.findByName("shirt")).contains(new Clothes("shirt", 50, Category.NEW));
    }

    @Test
    void testRemoveItem() {
        Assertions.assertThat(clothesShop.removeItem("jeans")).contains(new Clothes("jeans", 60, Category.ON_SALE));
        Assertions.assertThat(clothesShop.getItemList()).doesNotContain(new Clothes("jeans", 60, Category.ON_SALE));
    }

    @Test
    void testGetAllItemNames() {
        Assertions.assertThat(clothesShop.getAllItemNames()).containsExactly("jeans", "shirt", "hat", "jacket", "shoes");
    }
}
