package 王者荣耀2;

import java.util.*;

/**
 * 这是绘制输出战场类
 * 用于战场环境的输出
 * 由m*n的矩阵组成
 */

public class BattleDraw extends Thread
{
	Hero he = new Hero();
	
	
    String [][] outline= new String[10][15];
    Scanner sc = new Scanner(System.in);

    BattleDraw() {
        for(int i=0;i<10;i++)
        for(int j=0;j<15;j++)
        {
            outline[i][j]="⭕";
        }
        
        try {Thread.sleep(1000);}
        catch(InterruptedException e) {}
        
    }

    
    
    public int Move(String p,String n,int ox,int oy)
    {
    	try {Thread.sleep(1000);}
        catch(InterruptedException e) {}
        if(p.equals("w"))
        {
        	if(ox-1<0)
        	{
        		System.out.println("超出地图范围！");
        	}
        	
        	else if(ox-1>=0&&outline[ox-1][oy]=="⭕")
        	{
        		outline[ox-1][oy]=n;
        		outline[ox][oy]="⭕";
        		
        		BattleShow();
        		return 1;
        	}
        	
        	else
        		System.out.println("无法通行！");
        }
        
        else if(p.equals("s"))
        {
        	if(ox+1>9)
        	{
        		System.out.println("超出地图范围！");
        	}
        	
        	else if(ox+1<=9&&outline[ox+1][oy]=="⭕")
        	{
        		outline[ox+1][oy]=n;
        		outline[ox][oy]="⭕";
        		
        		BattleShow();
        		return 1;
        	}
        	
        	else
        		System.out.println("无法通行！");
        	
        }
    	
        else if(p.equals("a"))
        {
        	if(oy-1<0)
        	{
        		System.out.println("超出地图范围！");
        	}
        	
        	else if(oy-1>=0&&outline[ox][oy-1]=="⭕")
        	{
        		outline[ox][oy-1]=n;
        		outline[ox][oy]="⭕";
        		
        		BattleShow();
        		return 1;
        	}
        	
        	else
        		System.out.println("无法通行！");
        	
        }
    	
        else if(p.equals("d"))
        {
        	if(oy+1>14)
        	{
        		System.out.println("超出地图范围！");
        	}
        	
        	else if(oy+1<=14&&outline[ox][oy+1]=="⭕")
        	{
        		outline[ox][oy+1]=n;
        		outline[ox][oy]="⭕";
        		
        		BattleShow();
        		return 1;
        	}
        	
        	else
        		System.out.println("无法通行！");
        	
        	
        }
        else 
        	System.out.println("输入无效！");
        
        return 0;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     *
     * 该函数用于输出战场
     * 可在操作后实时输出战场变化情况
     *
     */

    public void BattleShow()
    {for(int i=0;i<10;i++)
    {
        for (int j = 0; j < 15; j++)
        {
            System.out.print(outline[i][j]);
        }
        System.out.println();

    }}

    /**
     *
     * 该函数用于设置英雄的位置
     * 放置英雄到指定位置
     *
     * @param xx
     * @param yy
     * @param name
     * @return
     */

    public int SetPosition(int xx,int yy,String name)
    {

        if(outline[xx][yy]=="⭕") {

            outline[xx][yy] = name;
            return 1;
        }
        else {
            System.out.println("位置已被占用！");
            return 0;
        }

    }

    /**
     * 此函数用于改变英雄位置
     * 将英雄前进到某个位置
     * 包含对该位置合法性的判断
     * 位置非法时输出"该位置已被占用"
     *
     * @param xx
     * @param yy
     * @param change
     * @param name
     * @param flag
     * @return
     */

    public int ChangePosition(int yy,int xx,int change,String name,int flag)
    {
    	
    	if(change==0)
    	{
    		return 1;
    	}
    	else if(flag==1)
        {
            if(xx-change<0)
            {
                System.out.println("位置越界！");
                return 0;
            }
             else if(outline[xx-change][yy]=="⭕")
             {

                outline[xx - change][yy] = name;
                outline[xx][yy] = "⭕";
                return 1;
             }
        }

        else if(flag==2)
        {
            if(xx+change>9)
            {
                System.out.println("位置越界！");
                return 0;
            }
            else if(outline[xx+change][yy]=="⭕")
            {
                outline[xx+change][yy] = name;
                outline[xx][yy] = "⭕";
                return 1;
            }
            
        }
    	System.out.println("位置已被占用！");
           return 0; 

    }

public void MovePicture(int movenum,int start,int x,int flag)
{
	if(flag==1)
	{
		int q=movenum;
		int s=start;
		while(q--!=0)
		{
			outline[s][x]="⬆️";
			s--;
		}
	BattleShow();
	System.out.println("********************************");
	q=movenum;
	s=start;
	while(q--!=0)
	{
		outline[s][x]="⭕️";
		s--;
	}
	BattleShow();
	}
	
	else if(flag==2)
	{
		int q=movenum;
		int s=start;
		while(q--!=0)
		{
			outline[s][x]="⬇️️";
			s++;
		}
	BattleShow();
	System.out.println("*********************************");
	q=movenum;
	s=start;
	while(q--!=0)
	{
		outline[s][x]="⭕️";
		s++;
	}
	BattleShow();
		
		
		
		
		
	}
	
	
	
}
	public void MoveRight(int movenum,int start,int x,int flag)
	{
		if(flag==1)
		{
			int q=movenum;
			int s=start;
			while(q--!=0)
			{
				outline[s][x]="⬆️";
				s--;
			}
		BattleShow();
		System.out.println("********************************");
		q=movenum;
		s=start;
		while(q--!=0)
		{
			outline[s][x]="⭕️";
			s--;
		}
		BattleShow();
		
		}
	
}



};
