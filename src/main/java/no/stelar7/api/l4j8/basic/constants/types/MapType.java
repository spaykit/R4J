package no.stelar7.api.l4j8.basic.constants.types;

import java.awt.*;
import java.util.*;
import java.util.stream.*;

public enum MapType
{
    
    /**
     * Summoner's Rift Original Summer Variant
     */
    SUMMONERS_RIFT_SUMMER_OLD(1, new Rectangle(-269, -83, 14276, 14522)),
    /**
     * Summoner's Rift Original Autumn Variant
     */
    SUMMONERS_RIFT_AUTUMN_OLD(2, new Rectangle(-269, -83, 14276, 14522)),
    /**
     * The Proving Grounds Tutorial MapType
     */
    PROVING_GROUNDS(3, new Rectangle(-500, -500, 15000, 15000)),
    /**
     * Twisted Treeline Original Version
     */
    TWISTED_TREELINE_OLD(4, new Rectangle(0, 0, 15398, 15398)),
    /**
     * The Crystal Scar Dominion MapType
     */
    CRYSTAL_SCAR(8, new Rectangle(0, 0, 13987, 13987)),
    /**
     * Twisted Treeline Current Version
     */
    TWISTED_TREELINE(10, new Rectangle(0, 0, 15398, 15398)),
    /**
     * Summoner's Rift Current Version
     */
    SUMMONERS_RIFT(11, new Rectangle(-269, -83, 14276, 14522)),
    /**
     * Howling Abyss ARAM MapType
     */
    HOWLING_ABYSS(12, new Rectangle(-28, -19, 12849, 12858)),
    /**
     * Butcher's Bridge ARAM MapType
     */
    BUTCHERS_BRIDGE(14, new Rectangle(-28, -19, 12849, 12858));
    
    private final Integer   mapId;
    private final Rectangle bounds;
    
    MapType(final Integer code, final Rectangle bounds)
    {
        this.mapId = code;
        this.bounds = bounds;
    }
    
    public static Optional<MapType> getFromCode(final String mapId)
    {
        return Stream.of(MapType.values()).filter(t -> t.mapId.equals(Integer.valueOf(mapId))).findFirst();
    }
    
    public Rectangle getBounds()
    {
        return this.bounds;
    }
    
    public Integer getId()
    {
        return this.mapId;
    }
    
}
