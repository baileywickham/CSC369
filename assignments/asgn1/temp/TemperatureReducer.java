import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.Reducer.*;


public class TemperatureReducer
  extends Reducer<Text, IntWritable, Text, DoubleWritable> {

   @Override
   public void reduce(Text date,
	Iterable<IntWritable> temperatures, Context context)
        throws IOException, InterruptedException {
        double max=-1;
        int count = 0;
        for(IntWritable el: temperatures){
            if (el.get() > max) {
                max = el.get();
            }
        }
        context.write(date, new DoubleWritable(max));
    }
}

