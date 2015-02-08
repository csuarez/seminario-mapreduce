import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class GreekGodCounterMapReduceReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text token, Iterable<IntWritable> counts, Context context) throws IOException, InterruptedException {

	}
}