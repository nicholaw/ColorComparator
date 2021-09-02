package utils;

import app.ColorComparator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ColorHandler extends DefaultHandler {
    private ColorComparator controller;
    private ColorGroup currentColorGroup;

    public ColorHandler(ColorComparator controller) {
        this.controller = controller;
        currentColorGroup = null;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Check for color tag
        if(qName.equalsIgnoreCase("color")) {
            controller.addColorLabel(attributes.getValue("name"), attributes.getValue("value"), currentColorGroup);
        } else {
            //check for color group
            for(ColorGroup c : ColorGroup.values()) {
                if(c.getColorGroup() == qName)
                    currentColorGroup = c;
            }
        }
    }//startElement
}//class ColorHandler
