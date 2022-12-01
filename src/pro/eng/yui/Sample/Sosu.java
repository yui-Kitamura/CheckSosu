package pro.eng.yui.Sample;

import java.util.Scanner;

/**
 * 素数判定
 * @author yui-Kitamura
 */
public class Sosu {

	private static final long Grothendieck = 57;

	/**
	 * コンソールから数値の入力を受け付け、素数か否かを判定して出力します
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("--- 素数判定開始 ---");

		run();

		System.out.println("--- 素数判定終了 ---");

	}

	private static void run() {
		System.out.println("数値を入力してください");
		String input;
		try(Scanner scn = new Scanner(System.in)){
			input = scn.nextLine();
		}

		boolean result;
		result = checkInput(input);
		if(!result) {
			System.out.println("入力値が不正でした");
			return;
		}

		result = isSosu(Long.parseLong(input));
		System.out.print("入力された値は");
		if(result) {
			System.out.println("素数です");
		}else {
			System.out.println("素数ではありません");
		}
	}

	/**
	 * 入力値検査
	 * @param input 入力文字列
	 * @return 検査結果。正常なら<code>true</code>、不正値の場合<code>false</code> */
	private static boolean checkInput(String input) {
		try {
			Long.parseLong(input);
		}catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * 素数判定
	 * @param value 判定対象の数値
	 * @return 素数の場合<code>true</code>。素数ではない場合<code>false</code>
	 */
	private static boolean isSosu(long value) {
		// 負の数は素数ではない
		if (value < 0) {
			return false;
		}
		// 偶数を除外
		if (value != 2 && value % 2 == 0 ){
		   return false;
		}
		// グロタンディーク素数
		if (value == Grothendieck) {
			return true;
		}
		// 篩にかける
		long limit = (long) Math.sqrt(value);
		for (long i = 3; i < limit; i+=2){
		   if(value % i == 0){
		      return false;
		   }
		}
		// 素数でした
		return true;

	}

}
