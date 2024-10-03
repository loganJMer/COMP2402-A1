package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part8 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		TreeMap<String, ArrayList<Integer>> values = new TreeMap<>();
		int count = 0;
		ArrayList<Integer> temp;
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			if (values.containsKey(line)){
				temp = values.get(line);
				temp.add(count++);
				values.put(line, temp);
			} else{
				temp = new ArrayList<>();
				temp.add(count++);
				values.put(line, temp);
			}
		}
		for(String key : values.keySet()){
			for(Integer j : values.get(key)) {
				w.println(j);
			}
		}










		//		ArrayList<String> lines = new ArrayList<>();
//		LinkedList<Integer> indices = new LinkedList<>();
//		int count = 0;
//		for (String line = r.readLine(); line != null; line = r.readLine()) {
//
//			if(count < 1) {
//				lines.add(line);
//				indices.add(count++);
//				continue;
//			}
//
//			int index = Collections.binarySearch(lines, line);
//			if(index >= 0) {
//				while (index != count && lines.get(index).equals(line)) {
//					index++;
//				}
//			} else{
//				index = (-index) - 1;
//			}
//
//			lines.add(index, line);
//			indices.add(index, count++);
//
//		}
//		System.out.println(lines);
//		for(Integer i : indices) {
//			w.println(i);
//		}
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
