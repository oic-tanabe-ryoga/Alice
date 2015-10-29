package oic.team_universe.alice;

import android.util.Log;

public class Game_Mgr {

    static int nRoutineNo = 1;//共通ルーチンナンバー

    static void state(){
        //Todo ゲームマネージャーに移動
       switch (nRoutineNo){
            case 1://初期化
                Log.d("SurfaceView_G_Mgr1", "初期化");
                if(Game_Initialize.initialize()==true)
                    nRoutineNo=2;
                break;
            case 2://タイトル
                Log.d("SurfaceView_G_Mgr2", "タイトル");
                if(Game_Title.title()==true)
                    nRoutineNo=3;
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
            default:
                Log.d("SurfaceViewE", "重大なエラーが発生しました");
                break;
        }
    }
}
