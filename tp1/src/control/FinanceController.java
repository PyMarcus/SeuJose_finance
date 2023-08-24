package control;

import dao.impl.FinanceDAOImpl;
import model.Earning;
import model.Finance;
import model.Spending;
import util.UUIDParser;
import java.util.UUID;
import java.util.Vector;

/**
 * The type Finance controller.
 */
public class FinanceController {

    private String enviroment;
    private FinanceDAOImpl financeModel;
    private EarningController earning;
    private SpendingController spending;

    /**
     * Instantiates a new Finance controller.
     *
     * @param enviroment the enviroment
     */
public FinanceController(String enviroment) {
        this.enviroment = enviroment;
        this.financeModel = new FinanceDAOImpl(this.enviroment);
        this.earning = new EarningController(enviroment);
        this.spending = new SpendingController(enviroment);
    }

    /**
     * Gets all finances.
     *
     * @return the all finances
     */
public Vector<Finance> getAllFinances() {
        return financeModel.getAllFinances();
    }

    /**
     * Create.
     *
     * @param finace the finace
     */
public void create(Finance finace) {
        financeModel.createFinance(finace);
        if (finace.getValueEarn() == 0) {
            spending.create(new Spending(UUIDParser.generateUUID(), finace.getUuid(), finace.getValueSpend()));
        } else {
            earning.create(new Earning(UUIDParser.generateUUID(), finace.getUuid(), finace.getValueEarn()));
        }
    }

  /**
   * Remove.
   *
   * @param uuid the uuid
   */
  public void remove(UUID uuid) {
        if (uuid != null) {
            earning.remove(uuid);
            spending.remove(uuid);
            financeModel.removeFinance(uuid);
        }
    }
}
