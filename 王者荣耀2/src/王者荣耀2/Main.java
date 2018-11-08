package 王者荣耀2;

import java.io.*;

import java.util.*;

public class Main{

public static void main(String[]args)
{
File file2 = new File("/Users/goden/Desktop/wzry文档输入.txt");
	
	/****************************************************************尝试一（开始）
	
	// 下面是从文件file2读东西
			try {
				FileReader fileReader = new FileReader(file2);
				String s = null;
				char ch;
				try {
					char[] c = new char[100];
					fileReader.read(c,0,2); // 具体想得到文件里面的什么值（单个char？int？还是String?），
					System.out.println(c);
					fileReader.close();

	 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			尝试一（结束）*/
			
Scanner sc = null;
try {
	sc = new Scanner(file2);
} catch (FileNotFoundException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
}
	
	
	/*尝试三（开始）
	//读文件到Stringbuffer 
	Scanner sc= new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    String sourcePath = "/Users/goden/Desktop/wzry文档输入.rtf";//源文件路径(*.*)
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(sourcePath));
        String str;
        while((str = br.readLine()) != null) {//逐行读取
            sb.append(str);//加在StringBuffer尾
            sb.append("\r\n");//行尾 加换行符
        }
        br.close();//别忘记，切记
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    
    尝试三（结束）*/
	
	
	/*File file2 = new File("/Users/goden/Desktop/wzry文档输入.rtf");
	Scanner sc;
	try {
		sc = new Scanner(file2);
	} catch (FileNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	*/
        System.out.println("请输入你要召唤的英雄：");
        BattleDraw a=new BattleDraw();
 
        Thread battle = new Thread(a);
        battle.start();
        
        ArrayList<Hero>List=new ArrayList<Hero>();
        //List.add();
        //List.add();
        
        
        for(int i=0;i<2;i++) {
                String name=sc.next();
                Hero hero = new Hero(name);
                List.add(hero);
        }
                a.SetPosition(0,7,List.get(1).name);
                List.get(1).Setxy(0,7);

                a.SetPosition(9,7,List.get(0).name);

                List.get(0).Setxy(9,7);
 
        a.BattleShow();
        
        String move;
        move=sc.next();
        
        if(move.equals("w")||move.equals("a")||move.equals("s")||move.equals("d"))
        {
        	while(!move.equals("exit"))
        	{
        	int flag;
        	System.out.printf("Text1: move的值：%s",move);
        	System.out.println();
        	System.out.printf("Text1: List的内部信息：%sx坐标：%d、y坐标：%d",List.get(0).name,List.get(0).x,List.get(0).y);
        	System.out.println();
        	flag=a.Move(move, List.get(0).name, List.get(0).x, List.get(0).y);
        	List.get(0).ChangeXY(move, flag);
        	move=sc.next();
        	}
        }
        
        
        
        
        
/*        RoundControl r = new RoundControl();
        while(flag!=0) {
                int lowrax,highrax,oplowrax,ophighrax;
                r.CountRound(flag);
                if(flag==1)
                {
                        lowrax=0;
                        highrax=5;
                        oplowrax=5;
                        ophighrax=10;
                }
                else
                {
                        lowrax=5;
                        highrax=10;
                        oplowrax=0;
                        ophighrax=5;
                        
                }
                
                //arraylist从零开始哦！！！！～～～
                
                
                int finalchange=0;
                System.out.println("请输入操作：1.移动 2.发呆 3.查看属性");
                System.out.println("          4.攻击 5.技能");
                int caozuo;
                caozuo=sc.nextInt();
                if(caozuo==1) {
                        System.out.println("请选择移动的英雄：");
                        for (int i = lowrax; i < highrax; i++)
                                System.out.printf("%d.%s ", i + 1, List.get(i).name);
                        System.out.println();

                        int mark = sc.nextInt();
                        int isok = 0;
                        mark--;
                        System.out.println("请输入前进的格数：");
                        		int start = 0;
                        		int end=0;
                        		int change = 0;
                                while (isok == 0) {
                                        change = sc.nextInt();
                                        start=List.get(mark).y;
                                        isok = a.ChangePosition(List.get(mark).x, List.get(mark).y, change, List.get(mark).name,flag);
                                        finalchange=change;
                                }
                                a.MovePicture(change, start, List.get(mark).x, flag);
                                List.get(mark).Changexy(List.get(mark).x,List.get(mark).y,finalchange,flag);
                }
                else if(caozuo==2)
                {
                        System.out.println("请选择发呆的英雄：");
                        for(int i=lowrax;i<highrax;i++)
                                System.out.printf("%d.%s ",i+1,List.get(i).name);
                        System.out.println();
                        int mark = sc.nextInt();
                        System.out.println("发呆成功！");
                        List.get(mark).ExpUp();
                }

                else if(caozuo==3)
                {
                        System.out.println("请选择查看的英雄：");
                        for(int i=lowrax;i<highrax;i++)
                                System.out.printf("%d.%s ",i+1,List.get(i).name);
                        System.out.println();
                        int mark = sc.nextInt();
                        List.get(mark-1).show();
                }
                else if(caozuo==4)
                {
                	System.out.println("请选择发起攻击的英雄：");
                    for (int i = lowrax; i < highrax; i++)
                            System.out.printf("%d.%s ", i + 1, List.get(i).name);
                    System.out.println();
                    int attacker = sc.nextInt();
                    attacker--;
                //****************************************    
                    if(List.get(attacker).isdead==0)
                    	System.out.println("Can not attack, this hero is dead!");
                    
                    else {
                    	
                    System.out.println("请选择你要攻击的英雄：");
                    for (int i = oplowrax; i < ophighrax; i++)
                            System.out.printf("%d.%s ", i + 1, List.get(i).name);
                    System.out.println();
                    int suffer = sc.nextInt();
                    //************这里非常重要
                    suffer--;
                    //************
                    if(List.get(suffer).isdead==0)
                    {	
                    	System.out.println("Can not attack, this hero is dead!");
                    }
                    
                    
                    else 
                    {
    
                    //int text=Math.abs(List.get(attacker).ReturnY()-List.get(suffer).ReturnY());
                    //System.out.println("Attacker的y坐标"+List.get(attacker).ReturnY());
                    //System.out.println("Suffer的y坐标"+List.get(suffer).ReturnY());
                    //System.out.println("测试距离："+text);
                    
                	if(Math.abs(List.get(attacker).ReturnY()-List.get(suffer).ReturnY())<=List.get(attacker).attackArea)
                	{
                		
                		System.out.printf("%s🔪           %s",List.get(attacker).name,List.get(suffer).name);
                		System.out.println();
                		System.out.println();
                		System.out.println();
                		System.out.printf("%s  🔪         %s",List.get(attacker).name,List.get(suffer).name);
                		System.out.println();
                		System.out.println();
                		System.out.println();
                		System.out.printf("%s      🔪     %s",List.get(attacker).name,List.get(suffer).name);
                		System.out.println();
                		System.out.println();
                		System.out.println();
                		System.out.printf("%s         🔪  %s",List.get(attacker).name,List.get(suffer).name);
                		System.out.println();
                		System.out.println();
                		System.out.println();
                		System.out.printf("%s             ❌",List.get(attacker).name);
                		System.out.println();
                		System.out.println();
                		System.out.println();
                		System.out.printf("%s             %s",List.get(attacker).name,List.get(suffer).name);
                		System.out.println();
                		List.get(suffer).SufferAttack(List.get(attacker).attack);
                		System.out.println("攻击成功！");
                		List.get(suffer).show();
                	}
                	else
                		System.out.println("超出攻击范围！");
                    }     	
                    }
                    }
                
                
                else if(caozuo==5)
                {
                	System.out.println("请选择发动技能的英雄：");
                    for (int i = lowrax; i < highrax; i++)
                            System.out.printf("%d.%s ", i + 1, List.get(i).name);
                    System.out.println();
                    int mark = sc.nextInt();
                    mark--;
                    if(List.get(mark).symbol==0) {
                    a.BattleShow();
                    
                    System.out.println("********************************");
                    System.out.printf("💊         %s",List.get(mark).name);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.printf("      💊   %s",List.get(mark).name);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.printf("         💊%s",List.get(mark).name);
                    System.out.println();
                    System.out.println("********************************");
                    System.out.println();
                	List.get(mark).skill();
                }
                    else if(List.get(mark).symbol==1){
                    	List.get(mark).skill();
                    	System.out.println("请选择你要攻击的英雄：");
                        for (int i = oplowrax; i < ophighrax; i++)
                                System.out.printf("%d.%s ", i + 1, List.get(i).name);
                        System.out.println();
                        int suffer = sc.nextInt();
                        //************这里非常重要
                        suffer--;
                        //************
                        System.out.println("🍃🍃🍃🍃🍃🍃🍃🍃🍃");
                        
                        System.out.println("🍃🍃🍃");
                        System.out.printf("🍃%s🍃",List.get(mark).name);
                        System.out.printf("🌪🌪🌪🌪❌");
                        System.out.printf("%s",List.get(suffer).name);
                        System.out.println();
                        System.out.println("🍃🍃🍃");
                        
                        System.out.println("🍃🍃🍃🍃🍃🍃🍃🍃🍃");
                        List.get(suffer).SufferAttack(List.get(mark).skill());
                		System.out.println("技能：森林之语释放成功！");
                		List.get(suffer).show();
                    }
                    else if(List.get(mark).symbol==2)
                    {
                    	List.get(mark).skill();
                    	
                    	 System.out.println("⬇️⬇️⬇️");
                         
                         System.out.println("🔥🔥🔥");
                         System.out.printf("🔥%s🔥",List.get(mark).name);
                         System.out.println();
                         System.out.println("🔥🔥🔥");
                         
                         System.out.println("⬆️⬆️⬆️");
                    	
                         System.out.println("技能：狂暴之怒释放成功！攻击力显著提升");
                 		 List.get(mark).show();
                    	
                    	
                    }
                    
                    
                    
                }
                
        System.out.println("继续操作吗？ 1.yes 2.no");
                int newround=sc.nextInt();
                if(newround==2&&flag==1)
                {
                	flag=2;
                	for(int j=0;j<10;j++)
                	{
                		List.get(j).ExpUp();
                	}
                        
                }
                else if(newround==2&&flag==2)
                {
                        flag=1;
                        for(int j=0;j<10;j++)
                    	{
                    		List.get(j).ExpUp();
                    	}
                }
                
                
        }*/
        
        
        
        
        
        
        
}


}