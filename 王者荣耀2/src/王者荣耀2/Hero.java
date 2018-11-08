package 王者荣耀2;
/**
 * 此为创建英雄类
 * 包含英雄的基本属性：名称、HP、MP、Exp、level、坐标x、y
 *
 */

public class Hero {

	    String name;
	    String zhiye; //职业
	    int HP,MP,Exp,x,y;
	    int level;
	    int maxHP,maxMP,maxExp;
	    int attack,attackArea;
	    int isdead;
	    int symbol;
	    Hero(){
	        HP=500;
	        maxHP=500;
	        MP=200;
	        Exp=0;
	        attack=50;
	        attackArea=1;
	        maxExp=100;
	        level=0;
	        isdead=1;
	        symbol=0;
	        zhiye="putong";
	    }
	    Hero(String n){
	        name=n;
	        HP=500;
	        maxHP=500;
	        MP=200;
	        Exp=0;
	        maxExp=200;
	        level=0;
	        attack=50;
	        attackArea=1;
	        isdead=1;
	        symbol=0;
	    }
	    Hero(String n,String zy){
	    	 name=n;
	    	 level=0;
		     zhiye=zy;
	    	if(zy=="sheshou")
	    	{
	    		HP=600;
	    		maxHP=600;
	    		Exp=0;
	    		maxExp=200;
	    		attack=30;
	    		attackArea=3;
	    	}
	    	
	    	if(zy=="zhanshi")
	    	{
	    		HP=1000;
	    		maxHP=1000;
	    		Exp=0;
	    		maxExp=200;
	    		attack=50;
	    		attackArea=1;
	    	}
	    }
	    /**
	     *
	     * 此函数用于初始化英雄的坐标参数
	     *
	     * @param x1 英雄的横坐标
	     * @param y1 英雄的纵坐标
	     */
	    public void Setxy(int x1,int y1)
	    { 
	            x=x1;
	            y=y1;
	    }

	    /**
	     * 此函数用于修改英雄坐标
	     *
	     * @param x1 英雄的原横坐标
	     * @param y1 英雄的原纵坐标
	     * @param change 英雄移动的距离
	     * @param flag 识别双方英雄的标记
	     */
/*
	    public void Changexy(int x1,int y1,int change,int flag)
	    {
	        if(flag==1)
	        {
	            x=x1;
	            y=y1-change;

	        }
	        if(flag==2)
	        {
	            x=x1;
	            y=y1+change;
	        }
	    }
*/
	    /**
	     * 此函数用于输出英雄的属性信息
	     */
	    public void show()
	    {
	        System.out.printf("Name:%s HP:%d MP:%d Exp:%d AttackArea:%d isAlive:%d",name,HP,MP,Exp,attackArea,isdead);
	        System.out.println();
	        System.out.printf("Attack:%d",attack);
	        System.out.println();
	        System.out.printf("坐标x：%d, 坐标y：%d",x,y);
	        System.out.println();
	    }
	/**
	 * 此函数提升英雄的经验值
	 * 并且到达升级经验值后
	 * 提升英雄的等级
	 * 并且增加英雄的属性值
	 * 回复部分生命HP和法力值MP
	 */
	    public void ExpUp()
	    {
	    	Exp+=50;
	    	System.out.print("Exp增加");
	    	System.out.print(name);
	    	System.out.println("当前经验值为："+Exp);
	    	
	    	if(Exp>=maxExp)
	    	{
	    		level++;
	    		System.out.printf("%s level up! Level=%d",name,level);
	    		System.out.println();
	    		int more=Exp-maxExp;
	    		maxExp+=100;
	    		Exp=0;
	    		Exp+=more;
	    		maxHP+=80;
	    		maxMP+=100;
	    		MP=maxMP;
	    		attack+=40;
	    		if(HP+(maxHP/3)>maxHP)
	    		{
	    			HP=maxHP;
	    		}
	    		else
	    			HP+=(maxHP/3);
	    	}
	    	
	    	
	    	if(Exp>500)
	    	{
	    		System.out.print("英雄："+name);
	    		System.out.print("可以转职");
	    		//zhuanzhi=1;
	    	}
	    	
	    }
	/**
	 * 此函数用于判断英雄是否能发起攻击
	 * @param flag 识别双方英雄的标记
	 * @return 返回是否能够攻击的判断参数
	 */
	    public int AttackArea(int flag)
	    {
	    	
	    }
	    
	    
	    /**
	     * 
	     * 此函数回复英雄的HP
	     * 
	     */
	    public void ReviewHP()
	    {
	    	if(HP+30<maxHP)
	    	{
	    		HP+=30;
	    	}
	    	else
	    		HP=maxHP;

	    }
	    /**
	     * 
	     * 此函数结算英雄受到的伤害
	     * 并且判断英雄是否死亡
	     * @param damage 英雄受到的伤害
	     */
	    
	    public void SufferAttack(int damage)
	    {
	    	HP-=damage;
	    	if(HP<=0)
	    	{
	    		isdead=0;
	    		System.out.printf("%s is dead!",name);
	    		System.out.println();
	    		name="🚫";
	    	}
	    }
	    /**
	     * 
	     * 此函数用于技能的释放
	     * 根据不同的技能
	     * 使用不同的方法进行构造
	     * @return 无伤害技能返还0，有伤害技能返还伤害
	     */
	    public int Skill()
	    {
	    	if(zhiye=="zhanshi")
	    	{
	    		
	    		
	    	}
	    	
	    	if(zhiye=="sheshou")
	    	{
	    		
	    		
	    		
	    	}
	    	
	    	
	    	
	    }
	    /**
	     * 此函数用于返还英雄的纵坐标
	     * @return 返还英雄的纵坐标
	     */
		public int ReturnY() {
			
			return y;
		}
		
		public void changeX(int i)
		{
			x+=i;
		}
		
		public void changeY(int i)
		{
			y+=i;
		}
		
		
		
		public void ChangeXY(String p,int flag)
	    {
	    	
			if(flag==1)
			{ 
				if(p.equals("w"))
					x--;
	        
				else if(p.equals("s"))
					x++;
	    	
				else if(p.equals("a"))
					y--;
	    	
				else if(p.equals("d"))
					y++;
	        
			}
	    	
	    }
		
		
	    
	}













	
	
	
	
	
	
