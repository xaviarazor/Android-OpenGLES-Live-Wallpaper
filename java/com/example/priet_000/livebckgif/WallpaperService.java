package com.example.priet_000.livebckgif;

/**
 * Created by priet_000 on 11/7/2015.
 */
public class WallpaperService extends  OpenGLES2WallpaperService {
    @Override
    Renderer getNewRenderer(){
        return new Renderer();
    }
}
