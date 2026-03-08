package com.example.map;

/**
 * A single map marker.
 *
 * Intrinsic state  → shared MarkerStyle (obtained from MarkerStyleFactory)
 * Extrinsic state  → lat, lng, label  (unique per marker)
 */
public class MapMarker {

    // extrinsic — unique to each marker instance
    private final double lat;
    private final double lng;
    private final String label;

    // intrinsic — shared flyweight object
    private final MarkerStyle style;

    /**
     * Preferred constructor: caller supplies a pre-fetched (shared) MarkerStyle.
     * MapDataSource obtains styles via MarkerStyleFactory and passes them here.
     */
    public MapMarker(double lat, double lng, String label, MarkerStyle style) {
        this.lat   = lat;
        this.lng   = lng;
        this.label = label;
        this.style = style;
    }

    public double     getLat()   { return lat;   }
    public double     getLng()   { return lng;   }
    public String     getLabel() { return label; }
    public MarkerStyle getStyle() { return style; }
}
