import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.filecache.DistributedCache;


public class GreekGodCounterMapReduce {
	public static void main (String[] args) throws Exception {

		Job job = new Job();
		job.setJarByClass(GreekGodCounterMapReduce.class);
		job.setJobName("GreekGodCounterMapReduce");
		TextInputFormat.addInputPath(job, new Path(args[0])); 
		job.setInputFormatClass(TextInputFormat.class);
		job.setMapperClass(GreekGodCounterMapReduceMapper.class);
		job.setReducerClass(GreekGodCounterMapReduceReducer.class); 
		TextOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.waitForCompletion(true);

	}
}