import React, { useState } from "react";

const ExpenseList = () =>{

    const[expenses, setExpenses]= useState([])

    const getExpenses = async() => {
        try{
        
        const data1 = await axios.get("http://localhost:5173/?#/expenses")
        console.log("data is ", data)
        }catch(err){
            console.log("error is",error);
        }
    }

    getExpenses()
    return (
        <div className='bg-white rounded-2xl shadow-md p-6 mb-6'>
      <h2 className='text-xl font-semibold text-gray-700 mb-4'>Expense List</h2>

        <table className=' w-full text-sm text-left'>

            <thead>
                <tr className=' bg-gray-100 text-gray-600 uppercase text-xs font-sm'>
                    <td className=' px-4 py-3 '>#</td>
                    <td className='px-4 py-3'>Title</td>
                    <td className='px-4 py-3'>Category</td>
                    <td className='px-4 py-3'>Price </td>
                    <td className='px-4 py-3'>Date</td>
                    <td className='px-4 py-3 text-center'>Action</td>
                </tr>
            </thead>

            <tbody>
                <tr className='border-b border-gray-200 hover:bg-gray-50 transition-colors'>
                    <td className='px-4 py-3 text-gray-400' >1</td>
                    <td className='px-4 py-3 text-gray-700 font-medium' >Mobile Rechare</td>
                    <td className='px-4 py-3'><span className='bg-blue-100 text-blue-700 font-semibold rounded-full px-2 py-1 text-xs'>Utilities</span></td>
                    <td className='px-4 py-3 font-semibold text-gray-700'>999.98</td>
                    <td className='px-4 py-3 text-gray-600'>2026-10-06</td>

                    <td className='px-4 py-3'>
                        
                        <div className='flex gap-2 justify-center'>

                        <button className='bg-yellow-400 hover:bg-yellow-500  text-white 
                                            font-semibold rounded-lg px-3 py-1.5 transition-colors
                                            duration-200 text-xs'>Edit</button>

                        <button className='bg-red-400 hover:bg-red-500  text-white 
                                            font-semibold rounded-lg px-3 py-1.5 transition-colors
                                            duration-200 text-xs'>Delete</button>

                        </div>

                    </td>
                </tr>

            </tbody>

        </table>

        </div>


    )
}

export default ExpenseList