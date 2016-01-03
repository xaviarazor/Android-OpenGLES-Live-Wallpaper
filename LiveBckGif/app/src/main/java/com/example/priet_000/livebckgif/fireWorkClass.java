package com.example.priet_000.livebckgif;

/**
 * Created by priet_000 on 12/31/2015.
 */
public class fireWorkClass {
    private int frame;
    private float limit=5.0f;
    private float position;
    private float[] fireWorkExp;


    private float[] addForm(float[] li,float[] form,float xOffset,float yOffset,float zOffset,float xScale,float yScale,float zScale,float r,float g, float b, float a){
        float[] res;
        float[] formArray=new float[form.length];
        for(int i=0;i<formArray.length;i++){
            formArray[i]=form[i];
        }
        for(int i=0;i<formArray.length/7;i++){
            formArray[(i*7)]*=xScale;
            formArray[(i*7)+1]*=yScale;
            formArray[(i*7)+2]*=zScale;
            formArray[(i*7)]+=xOffset*position;
            formArray[(i*7)+1]+=yOffset*position;
            formArray[(i*7)+2]+=zOffset*position;


            formArray[(i*7)+3]=r;
            formArray[(i*7)+4]=g;
            formArray[(i*7)+5]=b;
            formArray[(i*7)+6]=1.0f-(position/limit);
        }
        res=new float[li.length+formArray.length];
        for(int i=0;i<li.length;i++){
            res[i]=li[i];
        }
        for(int i=0;i<formArray.length;i++){
            res[i+li.length]=formArray[i];
        }
        return res;
    }

    private final float[] formFireworks=new float[]{
//------------------Face1---------------------------
            -0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,
//------------------Face2---------------------------
            -0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,
//------------------Face3---------------------------
            0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,
//------------------Face4---------------------------
            -0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,
//------------------Face5---------------------------
            -0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,-0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,
//------------------Face6---------------------------
            -0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            -0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,-0.05f,
            1.0f,1.0f,1.0f,1.0f,

            0.05f,0.05f,0.05f,
            1.0f,1.0f,1.0f,1.0f
    };


    public fireWorkClass(float starting){
        frame=0;
        position=starting;
        fireWorkExp=new float[0];

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);


        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);



        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
    }
    public void update(){
        if(position>limit) {
            reset();
        }
        frame+=1;
        position+=0.2f;
        fireWorkExp=new float[0];
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.0f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.0f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);


        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.0f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.0f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);



        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.05f,-0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.05f,-0.05f,-0.05f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.1f,-0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.1f,-0.1f,-0.1f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.15f,-0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.15f,-0.15f,-0.15f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.0f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,0.0f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,0.2f,-0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);
        fireWorkExp=addForm(fireWorkExp,formFireworks,-0.2f,-0.2f,-0.2f,0.25f,0.25f,0.25f,1.0f,1.0f,1.0f,1.0f);

    }
    public int getFrame(){
        return frame;
    }
    public float getPosition(){
        return position;
    }
    public float[] getFirework(){
        return fireWorkExp;
    }
    public void reset(){
        frame=0;
        position=1.0f;
    }
    public float getLimit(){
        return limit;
    }
}
