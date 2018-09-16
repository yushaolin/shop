// by zhangxinxu welcome to visit my personal website http://www.zhangxinxu.com/
// zxx.drag v1.0 2010-03-23 元素的拖拽实现
import $ from 'jquery';

let params = {
	left: 0,
	top: 0,
	currentX: 0,
	currentY: 0,
	flag: false
};
//获取相关CSS属性
let getCss = function(o, key) {
	return o.currentStyle ? o.currentStyle[key] : document.defaultView.getComputedStyle(o, false)[key];
};

/**
 * 拖拽的实现
 * @param bar 拖拽的控件
 * @param target 移动的控件
 * @param area 移动的范围
 * @param callback
 */
let startDrag = function(bar, target, area, callback) {
    params.flag = false;
    let offsetLeft = 0,
        offsetTop = 0;
    if (area) {
        let position = getCss(target, "position");
        if (position === 'fixed') {
            let box = area.getBoundingClientRect();
            offsetLeft = box.left;
            offsetTop = box.top;
        } else {
            offsetLeft = area.offsetLeft;
            offsetTop = area.offsetTop;
        }
    }
    // 若未设置限制范围，则默认不移出浏览器可视区域
    area = area ? $(area) : $(document);

	if (getCss(target, "left") !== "auto") {
		params.left = getCss(target, "left");
	} else if (getCss(target, "right") !== "auto") {
        let right = getCss(target, "right"),
            width = area.width();
        params.left = width - right;
    }
	if (getCss(target, "top") !== "auto") {
		params.top = getCss(target, "top");
	}

	//o是移动对象
	bar.onmousedown = function(event) {
		params.flag = true;
		if (!event) {
			event = window.event;
			//防止IE文字选中
			bar.onselectstart = function() {
				return false;
			};
		}
		let e = event;
        bar.style.cursor = 'move';
		params.currentX = e.clientX;
		params.currentY = e.clientY;
	};
	document.onmouseup = function() {
		params.flag = false;
        bar.style.cursor = '';
		if (getCss(target, "left") !== "auto") {
			params.left = getCss(target, "left");
		}
		if (getCss(target, "top") !== "auto") {
			params.top = getCss(target, "top");
		}
	};
	document.onmousemove = function(event) {
		let e = event || window.event;
		if (params.flag) {
			let nowX = e.clientX;
			let nowY = e.clientY;
			let disX = nowX - params.currentX;
			let disY = nowY - params.currentY;
			let _left = parseInt(params.left) + disX;
			let _top = parseInt(params.top) + disY;
			// 限制移动范围，不允许移出可视区域
			// 左、上边界
			_left = _left > offsetLeft ? _left : offsetLeft;
			_top = _top > offsetTop ? _top : offsetTop;
			// 右、下边界
			let width = area.width() + offsetLeft;
			let targetW = $(target).width();
			let height = area.height() + offsetTop;
			let targetH = $(target).height();
			_left = (_left + targetW > width) ? width - targetW : _left;
			_top = (_top + targetH > height) ? height - targetH : _top;

			target.style.left = _left + "px";
			target.style.top = _top + "px";

			if (typeof callback === "function") {
				callback(_left, _top);
			}

			if (event.preventDefault) {
				event.preventDefault();
			}
			return false;
		}
	}
};

export default startDrag;
