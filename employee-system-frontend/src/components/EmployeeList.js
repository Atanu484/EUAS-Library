
import React, {useState, useEffect} from 'react';
import { useNavigate } from "react-router-dom";
import EmployeeService from '../services/EmployeeService';
import Employee from "./Employee";

const EmployeeList = () => {

    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [employees, setEmployees] = useState();

    // This methods gets the employees
    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
               const response = await EmployeeService.getEmployees(); 
               setEmployees(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        }
      fetchData();
    }, [])

    // Method filters and deletes the data based on id
    const deleteEmployee = (e, id) => {
        e.preventDefault();
        EmployeeService.deleteEmployee(id)
        .then((res) => {
            if(employees) {
                setEmployees((previousElement) => {
                    return previousElement.filter((employee) => employee.id !== id);
                })
            }
        })
    }

    return (
        <div className="container mx-auto my-8">
            <div className="h-12">
                <button
                onClick={() => navigate('/addEmployee')}
                type="button" className="text-white bg-gray-800 hover:bg-gray-900 focus:outline-none focus:ring-4 focus:ring-gray-300 font-medium rounded-full text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:hover:bg-gray-700 dark:focus:ring-gray-700 dark:border-gray-700">Add Employee</button>
            </div>
            <div className="flex shadow border-b">
                <table className="min-w-full">
                    <thead className="bg-gray-50">
                        <tr>
                            <th className='text-left'>First Name</th>
                            <th className='text-left'>Last Name</th>
                            <th className='text-left'>Email Id</th>
                            <th className='text-right px-24'>Actions</th>
                        </tr>
                    </thead>
                    {!loading && (
                    <tbody className='bg-white'>
                        {employees.map((employee) => (
                        <Employee employee={employee} 
                        deleteEmployee={deleteEmployee}
                        key={employee.id}></Employee>
                        ))};
                        </tbody>
                        )}
                </table>
            </div>
        </div>
    );
};

export default EmployeeList;