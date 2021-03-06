package com.albedo.java.modules.gen.domain.vo;

import com.albedo.java.common.core.util.StringUtil;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * 业务表Entity
 *
 * @author somewhere
 * @version 2013-10-15
 */
@XmlRootElement(name = "template")
@Data
@ToString
public class TemplateVo {

	public static final String F_NAME = "name";
	private static final long serialVersionUID = 1L;
	@Size(min = 1, max = 200)
	private String name; // 名称
	private String category; // 分类
	private String filePath; // 生成文件路径
	private String fileName; // 文件名
	private String content; // 内容

	private boolean ignoreOutput;

	@XmlTransient
	public String getCategory() {
		return category;
	}

	public List<String> getCategoryList() {
		if (category == null) {
			return Lists.newArrayList();
		} else {
			return Lists.newArrayList(StringUtil.split(category, StringUtil.SPLIT_DEFAULT));
		}
	}

	public void setCategoryList(List<String> categoryList) {
		if (categoryList == null) {
			this.category = "";
		} else {
			this.category = StringUtil.SPLIT_DEFAULT + StringUtils.join(categoryList, StringUtil.SPLIT_DEFAULT) + StringUtil.SPLIT_DEFAULT;
		}
	}
}
