var array = [2,3,1,7,5,4,6];

function sort(array){
	mergeSort(array, 0, array.length);
	console.log(array);
}

function mergeSort(a, l , r){
	if(l < r-1){
		var m = Math.floor((l+r)/2);
		mergeSort(a, l, m);
		mergeSort(a, m, r);
		merge(a, l, m, r);
	}
}

function merge(a, l, m, r){
	var left = new Array(m-l);
	var right = new Array(r-m);

	for(var i= 0 ; i < m-l ; i++){
		left[i] = a[l+i];
	}

	for(var i= 0 ; i < r-m ; i++){
		right[i] = a[m+i];
	}

	var i=0; j=0, k=l;
	while(i < m-l && j < r-m){
		if(left[i] <= right[j]){
			a[k] = left[i];
			i++;
		}
		else{
			a[k] = right[j];
			j++;
		}
		k++;
	}
	while(i < m-l){
		a[k] = left[i];
		k++;
		i++;
	}
	while(j < r-m){
		a[k] = right[j];
		k++;
		j++;
	}
}
