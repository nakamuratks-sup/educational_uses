package main;

import main.machine.MachineMain;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.prgMain();
	}

	private void prgMain() {
		MachineMain machine = new MachineMain();

		System.out.println("### 自販機プログラム開始 ###");
		machine.menuMain();
		System.out.println("### 自販機プログラム終了 ###");
	}
}
