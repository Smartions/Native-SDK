package com.smartions.sinomogo.connect.demo.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

public class CopyFileFromAssets {

	/**
	 * 
	 * @param myContext
	 * @param ASSETS_NAME
	 * @param savePath
	 * @param saveName
	 *            testCopy(Context context)
	 */
	public static String saveFilesDir = Environment.getExternalStorageDirectory() + "/SinoMoGoConnect";
	
	public static void copy(Context myContext, String ASSETS_NAME,
			String savePath, String saveName) {
		String filename = savePath + "/" + saveName;

		File dir = new File(savePath);
		if (!dir.exists())
			dir.mkdirs();
		try {
			if (!(new File(filename)).exists()) {
				InputStream is = myContext.getResources().getAssets()
						.open(ASSETS_NAME);
				FileOutputStream fos = new FileOutputStream(filename);
				byte[] buffer = new byte[7168];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Delete the folder or file
	 * 
	 * @param folderPath
	 *            String Folder path, or file's absolute path, such as:/mnt/sdcard/test/1.png
	 */
	public static void deleteDirectory(String folderPath) {
		try {
			// Delete all files and folders folder
			deleteAllFile(folderPath);
			File lastFile = new File(folderPath);
			if (lastFile.exists()) {
				// Finally delete empty folder
				lastFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete all files in folder
	 * 
	 * @param path
	 *            String Folder path, or file's absolute path, such as:/mnt/sdcard/test/1.png
	 */
	private static void deleteAllFile(String path) {
		// Set up a file in memory space, but not to create
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (file.isFile()) {
			file.delete();
		} else if (file.isDirectory()) {
			String[] tempList = file.list();
			File temp = null;
			for (int i = 0; i < tempList.length; i++) {
				if (path.endsWith(File.separator)) {
					temp = new File(path + tempList[i]);
				} else {
					temp = new File(path + File.separator + tempList[i]);
				}
				if (temp.isFile()) {
					temp.delete();
				}
				if (temp.isDirectory()) {
					// Delete file in folder first
					deleteAllFile(path + "/" + tempList[i]);
					// To delete an empty folder
					deleteDirectory(path + "/" + tempList[i]);
				}
			}
		}
	}
}
