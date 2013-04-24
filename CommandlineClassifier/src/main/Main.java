package main;
import java.io.File;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.supportVector.*;
import weka.classifiers.misc.SerializedClassifier;
import wekaglue.*;

public class Main {
	public static String MODEL = "/Users/christopherkack/Documents/Skola/intelligentasystem/weka_models/string_kernel_multiclass.model";
	public static String XRFF = "/Users/christopherkack/Documents/Skola/intelligentasystem/trainingset_stringkernel.xrff";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if ( args.length < 1) {
			System.out.println("Please send me a question");
			System.exit(0);
		}
		String question = args[0];
		for (String q : args) {
			System.out.println(q);
		}
		System.out.println(question);
		
		try {
			System.out.println(classify(question));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}
	
	public static String classify(String question) throws Exception {
		 WekaGlue wekaglue = new WekaGlue();
		 wekaglue.create(MODEL,XRFF);
		 String[] q = new String[1];
		 q[0] = question;
		 return wekaglue.classify(q);
		 

	}

}
