package main;
import java.io.File;
import java.io.FileNotFoundException;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.supportVector.*;
import weka.classifiers.misc.SerializedClassifier;
import wekaglue.*;

public class Main {
	//public static String MODEL =  System.getProperty("user.dir") + "/string_kernel_multiclass.model";
	//public static String XRFF =  System.getProperty("user.dir") + "/trainingset_stringkernel.xrff";
	public static String MODEL =  System.getProperty("user.dir") +"/../../quizkampen/models/quizkampen_stringkernel.model";
	public static String XRFF =  System.getProperty("user.dir") +"/../../quizkampen/quizkampen.xrff";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if ( args.length < 1) {
			System.out.println("Please send me a question");
			System.exit(0);
		}
		String question;
		if (args.length == 3) {
			System.out.println();
			Main.MODEL = System.getProperty("user.dir") +"/" +args[0];
			Main.XRFF = System.getProperty("user.dir") +"/" +args[1];
			question = args[2];
		}else {
			question = args[0];
		}
		
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
