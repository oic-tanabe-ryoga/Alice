package oic.team_universe.alice;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.util.ArrayList;

public class Game_Mgr {
    private ArrayList<Task> _taskList =new ArrayList<Task>();
    static int nRoutineNo = 1;//共通ルーチンナンバー

   Game_Mgr(){//Todo リスト追加
       _taskList.add(new FpsController());
       Log.d("SurfaceView_G_Mgr1", "task");
       switch (nRoutineNo){
           case 1://初期化
               Log.d("SurfaceView_G_Mgr1", "初期化");
               _taskList.add(new Game_Initialize());
               if(Game_Initialize.Initialize_flag()==true)nRoutineNo = 2;
               break;
           case 2://タイトル
               Log.d("SurfaceView_G_Mgr2", "タイトル");
               _taskList.add(new Game_Title());
               if(Game_Title.Title_flag()==true)nRoutineNo = 3;
               break;
           case 3://セレクト
               Log.d("SurfaceView_G_Mgr3", "セレクト");
               if(Game_Select.Select_flag()==true)
                   nRoutineNo=4;
               break;
           case 4://ゲーム
               Log.d("SurfaceView_G_Mgr4", "ゲーム");
               if(Game_Main.main()==true)
                   nRoutineNo=5;
               nRoutineNo=7;
               break;
           case 5://ゲームオーバー
               Log.d("SurfaceView_G_Mgr5", "ゲームオーバー");
               if(Game_Over.gameover()==true)
                   nRoutineNo=2;
               nRoutineNo=6;
               break;
           case 6://コンティニュー
               Log.d("SurfaceView_G_Mgr6", "コンテニュー");
               if(Game_Continue.cont()==true)
                   nRoutineNo=4;
               break;
           case 7://ゲームクリア
               Log.d("SurfaceView_G_Mgr7", "ゲームクリア");
               if(Game_Clear.clear()==true)
                   nRoutineNo=2;
               nRoutineNo=3;
               break;
           default://エラー
               Log.d("SurfaceViewE", "重大なエラーが発生しました");
               break;
       }


   }//タスクリスト追加

    public boolean onUpdate(){
        Log.d("SurfaceView_G_Mgr", "Update");
        for(int i=0; i<_taskList.size(); i++){
            if(_taskList.get(i).onUpdata() == false){ //更新失敗なら
                _taskList.remove(i);              //そのタスクを消す
                i--;
            }
        }
        return true;
    }//タスク処理

    public void onDraw(Canvas canvas) {
        Log.d("SurfaceView_G_Mgr", "Draw");
        canvas.drawColor(Color.WHITE);       //白で塗りつぶす
        for(int i=0; i<_taskList.size(); i++){
            _taskList.get(i).onDraw(canvas);//描画
        }
    }//タスク描画

    /*public void state(){
        Log.d("SurfaceView_G_Mgr", "state()");
        //Todo ゲームマネージャーに移動
       switch (nRoutineNo){
            case 1://初期化
                Log.d("SurfaceView_G_Mgr1", "初期化");
                if(Game_Initialize.initialize()==true) {
                    //Game_Title.title(true);
                    nRoutineNo = 2;
                }
                break;
            case 2://タイトル
                Log.d("SurfaceView_G_Mgr2", "タイトル");
                //if(Game_Title.title(false)==true) {
                    nRoutineNo = 3;
                //}
                break;
            case 3://セレクト
                Log.d("SurfaceView_G_Mgr3", "セレクト");
                if(Game_Select.select()==true)
                    nRoutineNo=4;
                break;
            case 4://ゲーム
                Log.d("SurfaceView_G_Mgr4", "ゲーム");
                if(Game_Main.main()==true)
                    nRoutineNo=5;
                    nRoutineNo=7;
                break;
            case 5://ゲームオーバー
                Log.d("SurfaceView_G_Mgr5", "ゲームオーバー");
                if(Game_Over.gameover()==true)
                    nRoutineNo=2;
                    nRoutineNo=6;
                break;
            case 6://コンティニュー
                Log.d("SurfaceView_G_Mgr6", "コンテニュー");
                if(Game_Continue.cont()==true)
                    nRoutineNo=4;
                break;
            case 7://ゲームクリア
                Log.d("SurfaceView_G_Mgr7", "ゲームクリア");
                if(Game_Clear.clear()==true)
                    nRoutineNo=2;
                    nRoutineNo=3;
                break;
            default://エラー
                Log.d("SurfaceViewE", "重大なエラーが発生しました");
                break;
        }

    }*/
}
