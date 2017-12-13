package Deal;

public class PhotoProduct extends Product {
    private double megaPx;
    private boolean digital;

    public double getMegaPx() {
        return megaPx;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setMegaPx(double megaPx) {
        this.megaPx = megaPx;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    @Override
    protected int calcDiscount(){
        int def = super.calcDiscount();
        if(!isDigital()){
            def+=20;
        }
        return def;
    }
}
