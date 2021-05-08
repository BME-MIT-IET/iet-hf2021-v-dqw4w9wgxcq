package hu.bme.vdqw4w9wgxcq;

import tr.com.srdc.ontmalizer.XML2OWLMapper;
import tr.com.srdc.ontmalizer.XSD2OWLMapper;

import java.io.File;
import java.io.FileOutputStream;

class Main {
    /**
     * Usage: cli-tool <schema> <in> <out>
     *
     * @param args <schema> <in> <out>
     */
    public static void main(String[] args) {
        checkArgs(args);

        File xsdFile = new File(args[0]);
        File xmlFile = new File(args[1]);
        File n3File = new File(args[2]);

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(xsdFile);
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part converts XML instance to RDF data model.
        XML2OWLMapper generator = new XML2OWLMapper(xmlFile, mapping);
        generator.convertXML2OWL();

        // This part prints the RDF data model to the specified file.
        try {
            n3File.getParentFile().mkdirs();

            FileOutputStream fout = new FileOutputStream(n3File);
            generator.writeModel(fout, "N3");
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkArgs(String[] args) {
        if (args.length != 3) {
            System.err.println("Incorrect arguments");
            System.err.println("Usage: cli-tool <schema> <in> <out>");
            System.exit(1);
        }
    }
}
