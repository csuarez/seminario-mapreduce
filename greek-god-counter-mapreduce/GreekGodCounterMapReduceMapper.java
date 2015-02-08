import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class GreekGodCounterMapReduceMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static String[] gods = {
        "Zeus",
        "Hera",
        "Poseidón",
        "Dioniso",
        "Apolo",
        "Artemisa",
        "Hermes",
        "Atenea",
        "Ares",
        "Afrodita",
        "Hefesto",
        "Deméter"
    };

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    }
}