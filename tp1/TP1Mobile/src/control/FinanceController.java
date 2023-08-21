package control;

import dao.impl.FinanceDAOImpl;
import model.Earning;
import model.Finance;
import model.Spending;
import util.UUIDParser;

import java.util.Vector;

public class FinanceController {

    private String enviroment;
    private FinanceDAOImpl financeModel;
    private int size;
    private EarningController earning;
    private SpendingController spending;
    public FinanceController(String enviroment){
        this.enviroment = enviroment;
        this.financeModel = new FinanceDAOImpl(this.enviroment);
        this.earning = new EarningController(enviroment);
        this.spending = new SpendingController(enviroment);
        this.size = financeModel.getSize();
    }

    public int getSize(){
        return this.size;
    }

    public Vector<Finance> getAllFinances(){
        return financeModel.getAllFinances();
    }

    public void create(Finance finace){
        financeModel.createFinance(finace);
        if(finace.getValueEarn() == 0){
            spending.create(new Spending(UUIDParser.generateUUID(), finace.getUuid(),finace.getValueSpend()));
        }else{
            earning.create(new Earning(UUIDParser.generateUUID(), finace.getUuid(),finace.getValueEarn()));
        }

    }
}
