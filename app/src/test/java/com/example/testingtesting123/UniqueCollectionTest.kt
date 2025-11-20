package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val addedItem = Item("Item1")
        collection.addItem(addedItem)
        val testItem = collection.get(0)

        assert(addedItem == testItem)
    }

    // test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("Item1"))   // tests if unique Item is not added

        assert(collection.size() == 1 &&
                collection.get(collection.size()-1).name == "Item1")    // ensures current Item was the latest added

        collection.addItem(Item("Item2"))
        collection.addItem(Item("item2"))   // tests if uniqueness is non-case sensitive

        assert(collection.size() == 2 &&
                collection.get(collection.size()-1).name == "Item2")    // ensures current Item was the latest added
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}