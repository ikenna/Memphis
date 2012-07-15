package net.ikenna.memphis.system;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class CsvEngine {

    private final String fileName;

    public CsvEngine(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<CsvRecord> data) {
        for (CsvRecord csvRecord : data) {
            writeNext(csvRecord);
        }
    }

    public void writeNext(CsvRecord record) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(fileName, true), '\t');
            writer.writeNext(record.getEntries());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not store contact", e);
        }
    }

    public List<CsvRecord> read() {
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName), '\t');
            List<CsvRecord> records = newArrayList();
            List<String[]> fileContents = reader.readAll();
            for (String[] stringArray : fileContents) {
                records.add(new CsvRecord(stringArray));
            }
            reader.close();
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
