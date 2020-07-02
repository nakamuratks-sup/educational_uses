package src.main;

import src.main.machine.CoinControl;
import src.main.machine.CoinControlImpl;
import src.main.machine.MachineMain;
import src.main.machine.VendMachine;
import src.main.machine.VendMachineImpl;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.prgMain();
	}

	private void prgMain() {
		VendMachine vmachine = new VendMachineImpl();
		CoinControl cctrl = new CoinControlImpl();
		MachineMain machine = new MachineMain();

		machine.setCoinctrl(cctrl);
		machine.setVenmachine(vmachine);

		System.out.println("### 自販機プログラム開始 ###");
		machine.menuMain();
		System.out.println("### 自販機プログラム終了 ###");
	}
}
