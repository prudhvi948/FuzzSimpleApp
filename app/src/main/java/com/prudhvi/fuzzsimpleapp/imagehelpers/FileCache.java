package com.prudhvi.fuzzsimpleapp.imagehelpers;

import android.content.Context;

import java.io.File;

/**
 * Created by prudhvi on 4/12/2015.
 * Source: Online tutorial
 */
public class FileCache {
    private File cacheDir;

    public FileCache(Context context){
        //Find the directory to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"TTImages_cache");
        else
            cacheDir=context.getCacheDir();
        if(!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url){
        String filename=String.valueOf(url.hashCode());
        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear(){
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }
}
