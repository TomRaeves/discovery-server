package com.company.discoveryserver;

import javax.xml.stream.*;
import java.io.*;
import java.util.*;

public class XML {

    public static <K, V> void save(Map<K, V> map, Writer out) throws IOException, XMLStreamException {

        XMLStreamWriter xsw = null;
        try {
            try {
                XMLOutputFactory xof = XMLOutputFactory.newInstance();

                xsw = xof.createXMLStreamWriter(out);
                xsw.writeStartDocument("utf-8", "1.0");
                xsw.writeStartElement("entries");
                xsw.writeCharacters("\r\n");

                // Do the Collection
                for (Map.Entry<K, V> e : map.entrySet()) {
                    xsw.writeStartElement("entry");
                    xsw.writeAttribute("ID", e.getKey().toString());
                    xsw.writeAttribute("IP", e.getValue().toString());
                    xsw.writeEndElement();
                    xsw.writeCharacters("\r\n");
                }

                xsw.writeEndElement();
                xsw.writeEndDocument();

            } finally {

                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {/* ignore */ }
                }
            }// end inner finally

        } finally {
            if (xsw != null) {
                try {
                    xsw.close();
                } catch (XMLStreamException e) { /* ignore */ }
            }
        }
    }
}