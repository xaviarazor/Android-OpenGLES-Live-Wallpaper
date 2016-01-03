package com.example.priet_000.livebckgif;
import android.opengl.*;
import android.view.MotionEvent;
import android.view.View;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Random;
import java.util.Timer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by priet_000 on 10/31/2015.
 */
public class Renderer implements GLSurfaceView.Renderer {
    /*
    int starting;
    int startingX;
    boolean previous;
    boolean active;*/
    private Random rand;
    private int vertexNumber;

    private float red=1.0f;
    private float green=0.0f;
    private float blue=0.0f;

    private float red2=0.0f;
    private float green2=1.0f;
    private float blue2=0.0f;

    private float red3=0.0f;
    private float green3=0.0f;
    private float blue3=1.0f;


    private int color;
    private float rx;
    private float ry;
    private float rz;

    private int color2;
    private float rx2;
    private float ry2;
    private float rz2;

    private int color3;
    private float rx3;
    private float ry3;
    private float rz3;
    private float[] addForm(float[] li,float[] form,float xOffset,float yOffset,float zOffset,float xScale,float yScale,float zScale,float r,float g, float b){
        float[] res;
        float[] formArray=new float[form.length];
        for(int i=0;i<formArray.length;i++){
            formArray[i]=form[i];
        }
        for(int i=0;i<formArray.length/7;i++){
            formArray[(i*7)]*=xScale;
            formArray[(i*7)+1]*=yScale;
            formArray[(i*7)+2]*=zScale;
            formArray[(i*7)]+=xOffset;
            formArray[(i*7)+1]+=yOffset;
            formArray[(i*7)+2]+=zOffset;


            formArray[(i*7)+3]=r;
            formArray[(i*7)+4]=g;
            formArray[(i*7)+5]=b;
        }
        res=new float[li.length+formArray.length];
        for(int i=0;i<li.length;i++){
            res[i]=li[i];
        }
        for(int i=0;i<formArray.length;i++){
            res[i+li.length]=formArray[i];
        }
        vertexNumber=(res.length/7);
        return res;
    }
    private float[] resetVertices(){
        vertexNumber=0;
        return new float[0];
    }
    private final float[] formDiagonal=new float[]{
//----------------------section 1------------------------------------
//-- +- -+ -+ +- ++
            -0.25f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.16f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.16f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.16f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.16f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.25f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,



    };
    private final float[] formMoreThan=new float[]{
//----------------------section 1------------------------------------
//-- +- -+ -+ +- ++
            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 2-------------------------------------------
            -0.05945f, 0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private final float[] formLessThan=new float[]{
//----------------------section 1------------------------------------
//-- +- -+ -+ +- ++
            0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.05945f, -0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 2-------------------------------------------
            0.05945f, 0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private final float[] formK=new float[]{
            -0.12945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//----------------------section 2------------------------------------
            -0.05945f, 0.0989f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 3-------------------------------------------
            -0.05945f, -0.0989f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private final float[] formR=new float[]{
            -0.12945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//----------------------section 2------------------------------------
            -0.05945f, 0.06f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//-----------------------section 3-----------------------------------------
//- -, + -, - +, - +, + -, + +
            0.03055f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.19f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.19f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 4-------------------------------------------
            -0.05945f, -0.0989f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private final float[] formO=new float[]{
            -0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.19f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.19f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//----------------------section 2------------------------------------
            0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.19f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//-----------------------section 3-----------------------------------------
            -0.19f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.23f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 4-------------------------------------------
//- -, + -, - +, - +, + -, + +
            //0.12f, 0.125f, 0.0f,
            0.0f, 0.23f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, 0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.19f, 0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 5-------------------------------------------
//- -, + -, - +, - +, + -, + +
            0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, -0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, -0.3f, 0.f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, -0.23f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 6-------------------------------------------
//- -, + -, - +, - +, + -, + +
            0.0f, -0.3f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, -0.23f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.0f, -0.23f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.19f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12f, -0.125f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private final float[] formD=new float[]{
            -0.12945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.12945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//----------------------section 2------------------------------------
//-- +- -+ -+ +- ++
            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, -0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,
//------------------------section 3-------------------------------------------
            -0.05945f, 0.1511f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.03055f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            -0.05945f, 0.25f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f,

            0.12945f, 0.0f, 0.0f,
            1.0f, 1.0f, 1.0f, 1.0f
    };
    private fireWorkClass firework;
    private fireWorkClass firework2;
    private fireWorkClass firework3;

    private FloatBuffer mTriangle1Vertices;
    private View.OnTouchListener listener;
    private final int mBytesPerFloat = 4;
    private float[] mViewMatrix = new float[16];
    private float[] mProjectionMatrix = new float[16];
    private float[] mModelMatrix = new float[16];
    private int mMVPMatrixHandle;
    private int mPositionHandle;
    private int mColorHandle;
    private float x=0.0f;
    private float[] mMVPMatrix = new float[16];
    /** How many elements per vertex. */
    private final int mStrideBytes = 7 * mBytesPerFloat;

    /** Offset of the position data. */
    private final int mPositionOffset = 0;

    /** Size of the position data in elements. */
    private final int mPositionDataSize = 3;

    /** Offset of the color data. */
    private final int mColorOffset = 3;

    /** Size of the color data in elements. */
    private final int mColorDataSize = 4;

    private void drawTriangle(FloatBuffer triangleBuffer){
        triangleBuffer.position(mPositionOffset);
        GLES20.glVertexAttribPointer(mPositionHandle, mPositionDataSize, GLES20.GL_FLOAT, false, mStrideBytes, triangleBuffer);
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        triangleBuffer.position(mColorOffset);
        GLES20.glVertexAttribPointer(mColorHandle, mColorDataSize, GLES20.GL_FLOAT, false, mStrideBytes, triangleBuffer);
        GLES20.glEnableVertexAttribArray(mColorHandle);
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexNumber);
    }


    public Renderer(){
        /*vertexNumber=0;
        starting=0;
        startingX=0;
        previous=false;
        active=false;*/
        color=0;
        color2=0;
        color3=0;
        rand=new Random();
        firework=new fireWorkClass(0.0f);
        firework2=new fireWorkClass(1.25f);
        firework3=new fireWorkClass(4.0f);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        final float eyeX = 0.0f;
        final float eyeY = 0.0f;
        final float eyeZ = 1.5f;
        final float lookX = 0.0f;
        final float lookY = 0.0f;
        final float lookZ = -5.0f;
        final float upX = 0.0f;
        final float upY = 1.0f;
        final float upZ = 0.0f;
        Matrix.setLookAtM(mViewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);
        final String vertexShader =
                "uniform mat4 u_MVPMatrix;      \n"
                        + "attribute vec4 a_Position;     \n"
                        + "attribute vec4 a_Color;        \n"
                        + "varying vec4 v_Color;          \n"
                        + "void main()                    \n"
                        + "{                              \n"
                        + "   v_Color = a_Color;          \n"
                        + "   gl_Position = u_MVPMatrix   \n"
                        + "               * a_Position;   \n"
                        + "}                              \n";
        final String fragmentShader =
                "precision mediump float;       \n"
                        + "varying vec4 v_Color;          \n"
                        + "void main()                    \n"
                        + "{                              \n"
                        + "   gl_FragColor = v_Color;     \n"
                        + "}                              \n";
        int vertexShaderHandle = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);
        if (vertexShaderHandle != 0){
            GLES20.glShaderSource(vertexShaderHandle, vertexShader);
            GLES20.glCompileShader(vertexShaderHandle);
            final int[] compileStatus = new int[1];
            GLES20.glGetShaderiv(vertexShaderHandle, GLES20.GL_COMPILE_STATUS, compileStatus, 0);
            if (compileStatus[0] == 0){
                GLES20.glDeleteShader(vertexShaderHandle);
                vertexShaderHandle = 0;
            }
        }
        if (vertexShaderHandle == 0){
            throw new RuntimeException("Error creating vertex shader.");
        }
        int fragmentShaderHandle = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER);

        if (fragmentShaderHandle!= 0){
            // Pass in the shader source.
            GLES20.glShaderSource(fragmentShaderHandle, fragmentShader);

            // Compile the shader.
            GLES20.glCompileShader(fragmentShaderHandle);

            // Get the compilation status.
            final int[] compileStatus = new int[1];
            GLES20.glGetShaderiv(fragmentShaderHandle, GLES20.GL_COMPILE_STATUS, compileStatus, 0);

            // If the compilation failed, delete the shader.
            if (compileStatus[0] == 0)
            {
                GLES20.glDeleteShader(fragmentShaderHandle);
                vertexShaderHandle = 0;
            }
        }

        if (fragmentShaderHandle == 0){
            throw new RuntimeException("Error creating vertex shader.");
        }
        // Create a program object and store the handle to it.
        int programHandle = GLES20.glCreateProgram();

        if (programHandle != 0){
            // Bind the vertex shader to the program.
            GLES20.glAttachShader(programHandle, vertexShaderHandle);

            // Bind the fragment shader to the program.
            GLES20.glAttachShader(programHandle, fragmentShaderHandle);

            // Bind attributes
            GLES20.glBindAttribLocation(programHandle, 0, "a_Position");
            GLES20.glBindAttribLocation(programHandle, 1, "a_Color");

            // Link the two shaders together into a program.
            GLES20.glLinkProgram(programHandle);

            // Get the link status.
            final int[] linkStatus = new int[1];
            GLES20.glGetProgramiv(programHandle, GLES20.GL_LINK_STATUS, linkStatus, 0);

            // If the link failed, delete the program.
            /*if (linkStatus[0] == 0)
            {
                GLES20.glDeleteProgram(programHandle);
                programHandle = 0;
            }*/
        }

        if (programHandle == 0){
            throw new RuntimeException("Error creating program.");
        }
        mMVPMatrixHandle = GLES20.glGetUniformLocation(programHandle, "u_MVPMatrix");
        mPositionHandle = GLES20.glGetAttribLocation(programHandle, "a_Position");
        mColorHandle = GLES20.glGetAttribLocation(programHandle, "a_Color");
        GLES20.glUseProgram(programHandle);
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height){
        GLES20.glViewport(0, 0, width, height);
        final float ratio = (float) width / height;
        final float left = -ratio;
        final float right = ratio;
        final float bottom = -1.0f;
        final float top = 1.0f;
        final float near = 1.0f;
        final float far = 10.0f;
        Matrix.frustumM(mProjectionMatrix, 0, left, right, bottom, top, near, far);
    }
    @Override
    public void onDrawFrame(GL10 gl){
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        //SystemClock.uptimeMillis() % 10000L;
        /*long time = System.currentTimeMillis()%10000L;
        float angleInDegrees = (360.0f / 10000.0f) * ((int) time);*/
        /*if(previous==false&&rendererService.held==true&&active==false){
            active=true;
            starting=rendererService.x;
            startingX=x;
        }
        if(active) {
            if(rendererService.held){
                x = startingX+(rendererService.x-starting);
            }
            else{
                active=false;
            }
        }*/
        if(firework.getPosition()>=firework.getLimit()) {
            rx=(rand.nextInt(100))/100.0f*0.6f;
            ry=(rand.nextInt(100))/100.0f*0.6f;
            rz=(rand.nextInt(100))/100.0f*0.6f;
            color=rand.nextInt(3);
            switch(color){
                case 0:
                    red=1.0f;
                    green=0.0f;
                    blue=0.0f;
                    break;
                case 1:
                    red=0.0f;
                    green=1.0f;
                    blue=0.0f;
                    break;
                default:
                    red=0.0f;
                    green=0.0f;
                    blue=1.0f;
                    break;
            }

        }


        if(firework2.getPosition()>=firework2.getLimit()) {
            rx2=(rand.nextInt(100))/100.0f*0.6f;
            ry2=(rand.nextInt(100))/100.0f*0.6f;
            rz2=(rand.nextInt(100))/100.0f*0.6f;
            color2=rand.nextInt(3);
            switch(color2){
                case 0:
                    red2=1.0f;
                    green2=0.0f;
                    blue2=0.0f;
                    break;
                case 1:
                    red2=0.0f;
                    green2=1.0f;
                    blue2=0.0f;
                    break;
                default:
                    red2=0.0f;
                    green2=0.0f;
                    blue2=1.0f;
                    break;
            }

        }



        if(firework3.getPosition()>=firework2.getLimit()) {
            rx3=(rand.nextInt(100))/100.0f*0.6f;
            ry3=(rand.nextInt(100))/100.0f*0.6f;
            rz3=(rand.nextInt(100))/100.0f*0.6f;
            color3=rand.nextInt(3);
            switch(color3){
                case 0:
                    red3=1.0f;
                    green3=0.0f;
                    blue3=0.0f;
                    break;
                case 1:
                    red3=0.0f;
                    green3=1.0f;
                    blue3=0.0f;
                    break;
                default:
                    red3=0.0f;
                    green3=0.0f;
                    blue3=1.0f;
                    break;
            }

        }
        firework.update();
        firework2.update();
        firework3.update();
        float[] triangle1VerticesData=resetVertices();


        triangle1VerticesData=addForm(triangle1VerticesData,formK,-0.285f,0.0f,-0.3f,0.5f,0.3f,0.5f,0.5f,0.5f,0.5f);
        triangle1VerticesData=addForm(triangle1VerticesData,formR,-0.185f,0.0f,-0.3f,0.5f,0.3f,0.5f,0.5f,0.5f,0.5f);
        triangle1VerticesData=addForm(triangle1VerticesData,formLessThan,-0.105f,0.0f,-0.3f,0.5f,0.5f,0.5f,1.0f,1.0f,1.0f);
        triangle1VerticesData=addForm(triangle1VerticesData,formDiagonal,0.055f,0.0f,-0.3f,0.5f,0.5f,0.5f,0.0f,0.7607f,0.0f);
        triangle1VerticesData=addForm(triangle1VerticesData,formMoreThan,0.205f,0.0f,-0.3f,0.5f,0.5f,0.5f,1.0f,1.0f,1.0f);
        triangle1VerticesData=addForm(triangle1VerticesData,formD,0.285f,0.0f,-0.3f,0.5f,0.3f,0.5f,1.0f,1.0f,1.0f);
        //triangle1VerticesData=addForm(triangle1VerticesData,formFireworks,0.0f,0.0f,0.0f,0.3f,0.3f,0.3f,1.0f,0.0f,0.0f);




        triangle1VerticesData = addForm(triangle1VerticesData, firework.getFirework(), rx, ry, rz, 0.3f, 0.3f, 0.3f, red, green, blue);
        triangle1VerticesData = addForm(triangle1VerticesData, firework2.getFirework(), rx2, ry2, rz2, 0.3f, 0.3f, 0.3f, red2, green2, blue2);
        triangle1VerticesData = addForm(triangle1VerticesData, firework3.getFirework(), rx3, ry3, rz3, 0.3f, 0.3f, 0.3f, red3, green3, blue3);




        mTriangle1Vertices = ByteBuffer.allocateDirect(triangle1VerticesData.length * mBytesPerFloat).order(ByteOrder.nativeOrder()).asFloatBuffer();
        mTriangle1Vertices.put(triangle1VerticesData).position(0);
        x-=1.0f;
        if(x<0){
            x=360+x;
        }
        Matrix.setIdentityM(mModelMatrix, 0);
        Matrix.rotateM(mModelMatrix, 0, (float)x, 0.0f, 1.0f, 0.0f);
        drawTriangle(mTriangle1Vertices);
        //previous=rendererService.held;
    }
}
