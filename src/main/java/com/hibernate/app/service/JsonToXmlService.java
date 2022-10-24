package com.hibernate.app.service;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

@Service
public class JsonToXmlService {
    public void convertJsonToXml() throws Exception {
        File jsonFile = new File("C:\\Shilpa\\workspace\\spring-boot-app\\json-xml-format\\src\\main\\java\\com\\hibernate\\app\\files\\input.json");
        File xmlFile = new File("C:\\Shilpa\\workspace\\spring-boot-app\\json-xml-format\\src\\main\\java\\com\\hibernate\\app\\files\\output.xml");
       // InputStream inputStream = new FileInputStream(jsonFile);
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
       // Document doc = builder.parse(inputStream);
         jsonToXml(jsonFile, xmlFile);
    }

    public  Document jsonToXml(File jsonFile, File xmlFile) throws Exception {
        Document docResponse = null;
        FileWriter fileWriter = new FileWriter(xmlFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        if (jsonFile == null) {
            throw new NullPointerException("Json file is empty or invalid ");
        }
        try {
            InputStream inputStream = new FileInputStream(jsonFile);
            StringBuilder builder = new StringBuilder();
            int ptr;
            while ((ptr = inputStream.read()) != -1) {
                builder.append((char) ptr);
            }
            JSONObject jsonObject = new JSONObject(builder.toString());
            String xml = XML.toString(jsonObject);
            bufferedWriter.write(xml.toString());
//
//            Transformer tf = TransformerFactory.newInstance().newTransformer();
//            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "YES");
//            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            tf.setOutputProperty(OutputKeys.INDENT, "no");
//            Writer out = new StringWriter();
//            tf.transform(new DOMSource(docResponse), new StreamResult(out));
//            System.out.println(out.toString());


        } catch (IOException ex) {
            System.out.println("Error writing to file '" + xmlFile + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
        return docResponse;
    }


}