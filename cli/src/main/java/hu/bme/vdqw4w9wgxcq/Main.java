package hu.bme.vdqw4w9wgxcq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.ontmalizer.XML2OWLMapper;
import tr.com.srdc.ontmalizer.XSD2OWLMapper;

class Main {
    public static void main(String[] args) {
        // cli-tool <schema> <in> <out>
        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File(args[1]));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part converts XML instance to RDF data model.
        XML2OWLMapper generator = new XML2OWLMapper(new File(args[2]), mapping);
        generator.convertXML2OWL();

        // This part prints the RDF data model to the specified file.
        try {
            File f = new File(args[3]);
            f.getParentFile().mkdirs();
            FileOutputStream fout = new FileOutputStream(f);
            generator.writeModel(fout, "N3");
            fout.close();

        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
        }
    }
}
