package com.example.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory — caches and returns shared MarkerStyle instances.
 *
 * Key format:  SHAPE|COLOR|SIZE|F  or  SHAPE|COLOR|SIZE|O
 * Example key: "PIN|RED|12|F"
 *
 * Thread-safety is intentionally omitted here (single-threaded CLI tool).
 * For multi-threaded use, guard the cache with a lock or use ConcurrentHashMap.
 */
public class MarkerStyleFactory {

    private static final Map<String, MarkerStyle> cache = new HashMap<>();

    private MarkerStyleFactory() { /* utility class, no instances */ }

    /**
     * Returns a cached MarkerStyle for the given combination.
     * A new instance is created and stored only on the first request
     * for that combination.
     */
    public static MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        return cache.computeIfAbsent(key, k -> new MarkerStyle(shape, color, size, filled));
    }

    /** Utility method — useful for QuickCheck / diagnostics. */
    public static int cachedCount() {
        return cache.size();
    }
}
