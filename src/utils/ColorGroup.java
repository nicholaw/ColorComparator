package utils;

/**
 * Represents the color group being described by the xml document.
 */
public enum ColorGroup {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    VIOLET("violet");

    final String colorGroup;

    /**
     * Constructs the enum.
     * @param str
     */
    ColorGroup(String str) {
        colorGroup = str;
    }

    /**
     * Returns the String name of the color group.
     * @return the name of the color group
     */
    public String getColorGroup() {
        return colorGroup;
    }

    /**
     * Returns a String representation of the enum value.
     * @return
     */
    @Override
    public String toString() {
        return colorGroup;
    }
}//enum Color