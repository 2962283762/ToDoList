<template>
	<view class="content">
		<view class="contaner">
			<view class="addArea">
				<input type="text" name="" id="" v-model="needToDo" confirm-type="done" @confirm="addFun"><button @click="addFun" @keydown.enter="addFun">+</button>
			</view>
			<view class="dataArea">
				<ul>
					<li v-for="(item,index) in toDoList"><span>{{item.text}}</span><button @click="deleteFun(index)">x</button></li>
					
				</ul>
			</view>
		</view>
		
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				needToDo:"",
				toDoList:[],
				
			}
		},
		onLoad() {
			uni.request({
				url:"http://perfetcdiary.bdbaq.cn/getter",
				method:'GET',
				success: (res) => {
					this.toDoList=res["data"];
					console.log(this.toDoList)
				}
			})

		},
		methods: {
			addFun(){
				let timeer=new Date();
				let timestamp=timeer.getTime();
				timestamp=timestamp.toString();
				let tmp={"isdelete":"0","text":"","timestamp":"","username":"2962283762"};
				tmp["timestamp"]=timestamp;
				tmp["text"]=this.needToDo;
				
				this.toDoList.push(tmp)
				uni.request({
					url:"http://perfetcdiary.bdbaq.cn/update",
					method:'GET',
					data:tmp,
					success: (res) => {
						uni.showToast({
							title:"添加成功",
							icon:'success',
						
						})
					}
					
				})
				
			},
			deleteFun(index){
				this.toDoList[index]["isdelete"]="1";
				uni.request({
					url:"http://perfetcdiary.bdbaq.cn/deleteer",
					data:this.toDoList[index],	
					success: (res) => {
						uni.showToast({
							title:"删除成功"
						})
						console.log(res.statusCode);
					}
				})
				this.toDoList.splice(index,index+1);
				
			}
			

		}
	}
</script>

<style>
	*{
		margin: 0;
		padding: 0;
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		width: 100%;
	}
	.contaner{
		width: 70%;
	}
	.addArea{
		display: flex;
		text-align: center;
		justify-content: center;
		align-items: center;
		border:1px solid #ff5500;
		margin-top: 10%;
	}
	.addArea button{
		flex: 1;
		background-color: #ff5500;
		color: white;
	}
	.addArea input{
		flex:4;
	}
	.dataArea{
		text-align: left;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		width: 100%;
		

	}
	ul{
		width: 100%;
	}
	li{
		display: flex;
		height: 30px;
		line-height: 30px;
		width: 100%;
		justify-content: center;
		align-items: center;
		border: 1px dashed #ccc;
		list-style: none;
	}
	li span{
		text-align: left;
		flex:4;
	}
	li button{
		height: 30px;
		line-height: 30px;
		text-align: center;
		background-color: rgba(0, 0, 0, 0);
		flex: 1;
	}
	button:active{
		background-color: aliceblue;
	}
</style>

