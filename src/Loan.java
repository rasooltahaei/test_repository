

public final class Loan {
    //Constractor
    public Loan(double principal,int duration,double anualinterestrate){
        this.setPrincipal(principal);
        this.setDuration(duration);
        this.setAnualinterestrate(anualinterestrate);
    }
    
    //Total principal
    private double principal;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = Math.max(principal, 1);
    }
    //duration (In Mounth)
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = Math.max(duration, 1);
    }
    //Anual Interest Rate
    private double anualinterestrate;

    public double getAnualinterestrate() {
        return anualinterestrate;
    }

    public void setAnualinterestrate(double anualinterestrate) {
        this.anualinterestrate = Math.max(anualinterestrate, 0);
    }
    //Mounthly interest rate
   public double getmounthlyinerestrate(){
       return this.getAnualinterestrate()/12;
   }
   //Mounthly payment
   public double getmounthlypaymetn(){
       double p=this.getPrincipal();
       int n=this.getDuration();
       double j=this.getmounthlyinerestrate()/100;
       double M=p*j/(1-Math.pow(1+j,-n));
       return M;
   }
   //Total payment
   public double gettotalpaymetn(){
       double M=this.getmounthlypaymetn();
       int n=this.getDuration();
       double B =n * M;
       return B;
   }
   //Total interest
   public double gettotalinterest(){
       double B = this.gettotalpaymetn();
       double p=this.getPrincipal();
       double T=B-p;
       return T; 
   }
   //monthly interest
   public double getmonthlyinterest(){
       return this.gettotalinterest()/this.getDuration();
   }
   //anual interest
   public double getanualinterest(){
       return this.getmonthlyinterest()*12;
   }
   
}
