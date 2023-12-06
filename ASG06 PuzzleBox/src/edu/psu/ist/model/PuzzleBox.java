package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * The {@code PuzzleBox} class represents a container for items with various operations.
 *
 * @param <T> The type of items in the puzzle box, must extend Comparable.
 */
public class PuzzleBox<T extends Comparable<T>> {

    private List<T> items;

    /**
     * Constructs an empty PuzzleBox.
     */
    public PuzzleBox() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a list of items to the puzzle box.
     *
     * @param items The list of items to be added.
     */
    public void addItemsTo(List<T> items) {
        this.items.addAll(items);
    }

    /**
     * Returns a string representation of the items in the puzzle box.
     *
     * @return A string containing the items in the puzzle box.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T item : items) {
            result.append(item).append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Clears all items from the puzzle box.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Returns the number of items in the puzzle box.
     *
     * @return The number of items in the puzzle box.
     */
    public int numOfItems() {
        return items.size();
    }

    /**
     * Sorts the items in the puzzle box in ascending order.
     */
    public void sort() {
        // Implement your sorting algorithm here
        // For simplicity, using Collections.sort() for now
        Collections.sort(items);
    }

    /**
     * Checks if the items in the puzzle box are in double order.
     *
     * @return True if the items are in double order, false otherwise.
     */
    public boolean inDoubleOrder() {
        return inDoubleOrderHelper(items);
    }

    private boolean inDoubleOrderHelper(List<T> itemList) {
        // Implement your recursive logic here
        return true;  // Placeholder, update accordingly
    }

    /**
     * Populates the puzzle box with random items using the specified item producer.
     *
     * @param itemProducer The producer for generating random items.
     */
    public void randomlyPopulate(IProducer<T> itemProducer) {
        clear();
        for (int i = 0; i < 8; i++) {
            T generatedItem = itemProducer.produce();
            items.add(generatedItem);
        }
    }
}

