package net.ikenna.memphis.system;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class CsvEngineTest {

    @Test
    public void testWriteCsv() throws Exception {
        List<CsvRecord> data = newArrayList();
        data.add(new CsvRecord().add("a").add("b"));
        new CsvEngine("members.csv").write(data);
    }


}
