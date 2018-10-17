package tk.arktech;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class FileReadXML implements FileReader {

    private ServerConnection sconn;
    private NodeList nList;

    public FileReadXML(ServerConnection sconn) {
        this.sconn = sconn;
        Document doc = null;
        sconn.downloadFile();
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(sconn.getFilepath());
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        if(doc!=null)
        {
            doc.getDocumentElement().normalize();
            this.nList = doc.getElementsByTagName("pozycja");
        }
        else
        {
            nList = null;
        }

    }

    public void Reload()
    {
        Document doc = null;
        sconn.downloadFile();
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(sconn.getFilepath());
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        if(doc!=null)
        {
            doc.getDocumentElement().normalize();
            this.nList = doc.getElementsByTagName("pozycja");
        }
        else
        {
            nList = null;
        }
    }

    @Override
    public CurrencyCollection readAsCurrencyCollection() {
        if(nList == null) {
            return null;
        }


        CurrencyCollection cColl = new CurrencyCollection();
        List<Currency> kol = cColl.getKolekcja();

        for(int i = 0; i<nList.getLength(); i++)
        {
            Node node = nList.item(i);

            if(node.getNodeType()==Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                kol.add(new Currency(element.getElementsByTagName("kod_waluty").item(0).getTextContent(),
                        element.getElementsByTagName("nazwa_waluty").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent()),
                        Double.parseDouble(element.getElementsByTagName("kod_waluty").item(0).getTextContent())));


            }

        }

        return cColl;
    }
}
