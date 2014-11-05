package org.fireking.app.imagelib;

/**
 * 公共配置文件
 * 
 * @author join
 *
 */
public class Config {

	static int limit;
	static String savePathString;

	static {
		limit = 4;
		savePathString = "/temp";
	}

	/**
	 * 设置最多可以选择的图片数量
	 * 
	 * @param limit
	 */
	public static void setLimit(int limit) {
		Config.limit = limit;
	}

	/**
	 * 获取最多可选择的图片数量
	 * 
	 * @return
	 */
	public static int getLimit() {
		return limit;
	}

	/**
	 * 文件保存路径<br />
	 * 主要处理拍照文件
	 * 
	 * @return
	 */
	public static void setSavePath(String path) {
		Config.savePathString = path;
	}

	/**
	 * 获取图片保存路径
	 * 
	 * @return
	 */
	public static String getSavePath() {
		return savePathString;
	}
}
